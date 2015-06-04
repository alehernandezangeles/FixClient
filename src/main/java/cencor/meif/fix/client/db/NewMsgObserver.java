package cencor.meif.fix.client.db;

import cencor.meif.fix.client.FixClientSvcImpl;
import cencor.meif.fix.client.Service;
import cencor.meif.fix.client.jpa.entities.CatEstatusEntity;
import cencor.meif.fix.client.jpa.entities.NosEntity;
import cencor.meif.fix.client.queue.ProducerController;
import org.apache.log4j.Logger;

import javax.jms.JMSException;
import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mhernandez on 6/1/15.
 */
public class NewMsgObserver implements Observer, Service {

    private static Logger logger = Logger.getLogger(NewMsgObserver.class);

    private NewMsgObservable newMsgObservable;
    private DBController dbController;
    private ProducerController producerController;

    /**
     * Crea un observador de nuevos mensajes
     * @param dbController Objeto para hacer consultas a la BD
     * @param producerController
     */
    public NewMsgObserver(DBController dbController, ProducerController producerController) {
        this.dbController = dbController;
        this.producerController = producerController;
        this.newMsgObservable = new NewMsgObservable(dbController);
        this.newMsgObservable.addObserver(this);
    }

    /**
     * Callback when new order arrives in DB
     * @param o Object that polls DB
     * @param newOrders List of new orders
     */
    @Override
    public void update(Observable o, Object newOrders) {
        List<Serializable> entities = (List<Serializable>) newOrders;
        for (Serializable entity : entities) {
            try {
                // enviar a la cola de nuevas peticiones
                producerController.putReq(entity);
                // cambiar el estatus de la orden a "Por enviar a MEIF"
                if (entity instanceof NosEntity) {
                    NosEntity nosEntity = (NosEntity) entity;
                    nosEntity.setEstatus(CatEstatusEntity.POR_ENVIAR_A_MEIF);
                    this.dbController.editNos(nosEntity);
                }
            } catch (JMSException e) {
                logger.error("Error al poner mensaje en la cola " + FixClientSvcImpl.REQ_QUEUE_NAME + ". Mensaje: " + entity, e);
            } catch (Exception e) {
                logger.error("Error al pesistir en BD: " + entity, e);
            }
        }
    }

    /**
     * Start polling DB
     */
    @Override
    public void start() {
        newMsgObservable.start();
    }
}
