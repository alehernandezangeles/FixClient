package cencor.meif.fix.client.jpa.controllers.test;

import cencor.meif.fix.client.jpa.controllers.NosEntityJpaController;
import cencor.meif.fix.client.jpa.entities.CatEstatusEntity;
import cencor.meif.fix.client.jpa.entities.NosEntity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

/**
 * Created by mhernandez on 5/29/15.
 */
public class NOS {
    private static EntityManagerFactory emf;

    @BeforeClass
    public static void init() {
        emf = Persistence.createEntityManagerFactory("jpaFixClientPU");
    }

    @AfterClass
    public static void free() {
        emf.close();
    }

    @Test
    public void insert() {
        Date date = new Date();

        NosEntityJpaController controller = new NosEntityJpaController(emf);
        NosEntity nosEntity = new NosEntity();
        nosEntity.setEstatus(CatEstatusEntity.NUEVO);
        nosEntity.setAccount("Account");
        nosEntity.setAllocQty(12000);
        nosEntity.setClOrdId("Id" + date.getTime());
        nosEntity.setComision(1.5);
        nosEntity.setContratoOper("ContratoOper");
        nosEntity.setCurrency("MXN");
        nosEntity.setCveOperadora("Oper2");
        nosEntity.setCveOrigen(1);
        nosEntity.setFechaSolicitud(new java.sql.Date(date.getTime()));
        nosEntity.setGrossTradeAmt(1212.12);
        nosEntity.setImporteSolicitado(12121212.25);
        nosEntity.setIva(16.0);
        nosEntity.setNumAsesorDist("AsesorDist");
        nosEntity.setOrdType("1");
        nosEntity.setPorcentajeComisionDist(2.44);
        nosEntity.setPrice(1200.21);
        nosEntity.setQuantity(77778);
        nosEntity.setSecurityId("SecurityId");
        nosEntity.setSecurityIdSource("4");
        nosEntity.setSecurityType("51");
        nosEntity.setSettlDate(new java.sql.Date(date.getTime()));
        nosEntity.setSettlType("0");
        nosEntity.setSide("1");
        nosEntity.setSymbol("EMINHC|BB");
        nosEntity.setTradeDate(new java.sql.Date(date.getTime()));
        nosEntity.setTransactTime(new java.sql.Timestamp(date.getTime()));
        nosEntity.setNetMoney(84.92);
        nosEntity.setAdicional1("Adicional 1");
        nosEntity.setAdicional2("Adicional 2");
        nosEntity.setAdicional3("Adicional 3");

        try {
            controller.create(nosEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertBatch1() {
        long t1 = new Date().getTime();
        for (int i = 0; i < 100; i++) {
            Date date = new Date();

            NosEntityJpaController controller = new NosEntityJpaController(emf);
            NosEntity nosEntity = new NosEntity();
            nosEntity.setEstatus(CatEstatusEntity.NUEVO);
            nosEntity.setAccount("Account");
            nosEntity.setAllocQty(12000);
            nosEntity.setClOrdId("Id" + date.getTime());
            nosEntity.setComision(1.5);
            nosEntity.setContratoOper("ContratoOper");
            nosEntity.setCurrency("MXN");
            nosEntity.setCveOperadora("Oper2");
            nosEntity.setCveOrigen(1);
            nosEntity.setFechaSolicitud(new java.sql.Date(date.getTime()));
            nosEntity.setGrossTradeAmt(1212.12);
            nosEntity.setImporteSolicitado(12121212.25);
            nosEntity.setIva(16.0);
            nosEntity.setNumAsesorDist("AsesorDist");
            nosEntity.setOrdType("1");
            nosEntity.setPorcentajeComisionDist(2.44);
            nosEntity.setPrice(1200.21);
            nosEntity.setQuantity(77778);
            nosEntity.setSecurityId("SecurityId");
            nosEntity.setSecurityIdSource("4");
            nosEntity.setSecurityType("51");
            nosEntity.setSettlDate(new java.sql.Date(date.getTime()));
            nosEntity.setSettlType("0");
            nosEntity.setSide("1");
            nosEntity.setSymbol("EMINHC|BB");
            nosEntity.setTradeDate(new java.sql.Date(date.getTime()));
            nosEntity.setTransactTime(new java.sql.Timestamp(date.getTime()));
            nosEntity.setNetMoney(84.92);
            nosEntity.setAdicional1("Adicional 1");
            nosEntity.setAdicional2("Adicional 2");
            nosEntity.setAdicional3("Adicional 3");

            try {
                controller.create(nosEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long t2 = new Date().getTime();
        System.out.println("Time: " + (t2-t1));
    }

    @Test
    public void insertBatch2() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        long t1 = new Date().getTime();
        for (int i = 0; i < 100; i++) {
            Date date = new Date();

            NosEntity nosEntity = new NosEntity();
            nosEntity.setEstatus(CatEstatusEntity.NUEVO);
            nosEntity.setAccount("Account");
            nosEntity.setAllocQty(12000);
            nosEntity.setClOrdId(date.getTime() + "_" + i);
            nosEntity.setComision(1.5);
            nosEntity.setContratoOper("ContratoOper");
            nosEntity.setCurrency("MXN");
            nosEntity.setCveOperadora("Oper2");
            nosEntity.setCveOrigen(1);
            nosEntity.setFechaSolicitud(new java.sql.Date(date.getTime()));
            nosEntity.setGrossTradeAmt(1212.12);
            nosEntity.setImporteSolicitado(12121212.25);
            nosEntity.setIva(16.0);
            nosEntity.setNumAsesorDist("AsesorDist");
            nosEntity.setOrdType("1");
            nosEntity.setPorcentajeComisionDist(2.44);
            nosEntity.setPrice(1200.21);
            nosEntity.setQuantity(77778);
            nosEntity.setSecurityId("SecurityId");
            nosEntity.setSecurityIdSource("4");
            nosEntity.setSecurityType("51");
            nosEntity.setSettlDate(new java.sql.Date(date.getTime()));
            nosEntity.setSettlType("0");
            nosEntity.setSide("1");
            nosEntity.setSymbol("EMINHC|BB");
            nosEntity.setTradeDate(new java.sql.Date(date.getTime()));
            nosEntity.setTransactTime(new java.sql.Timestamp(date.getTime()));
            nosEntity.setNetMoney(84.92);
            nosEntity.setAdicional1("Adicional 1");
            nosEntity.setAdicional2("Adicional 2");
            nosEntity.setAdicional3("Adicional 3");

            em.persist(nosEntity);
        }
        em.getTransaction().commit();
        long t2 = new Date().getTime();
        System.out.println("Time: " + (t2 - t1));
    }

    @Test
    public void findByStatus() {
        NosEntityJpaController controller = new NosEntityJpaController(emf);
        List<NosEntity> nosByEstatus = controller.findNosByEstatus(CatEstatusEntity.NUEVO);
        for (NosEntity nosByEstatu : nosByEstatus) {
            System.out.println(nosByEstatu);
        }
    }

}
