package cencor.meif.fix.client.db;

import cencor.meif.fix.client.jpa.entities.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alejandro on 5/31/15.
 */
public interface DBController {

    String DB_OPERATIONAL ="FixClientDB", DB_HISTORIC ="FixClientHistDB";
    List<String> TBL_NAMES = Arrays.asList("ACK1", "ACK2", "ER", "Errores", "NOS", "OCR", "OtrosMsjFix");

    List<NosEntity> getNewNos();

    List<OcrEntity> getNewOcr();

    void editNos(NosEntity nosEntity) throws Exception;
    NosEntity findNosByClOrdId(String clOrdId);

    void editOcr(OcrEntity ocrEntity) throws Exception;
    OcrEntity findOcrByClOrdId(String clOrdId);

    void createOtrosMsjFix(OtrosMsjFixEntity otrosMsjFixEntity) throws Exception;
    void createOtrosMsjFix(List<OtrosMsjFixEntity> otrosMsjFix);

    void createAck1(Ack1Entity ack1Entity) throws Exception;
    void createAck1(List<Ack1Entity> ack1s);

    void createAck2(Ack2Entity ack2Entity) throws Exception;
    void createAck2(List<Ack2Entity> ack2s);

    void createEr(ErEntity erEntity);

    void createEr(List<ErEntity> ers);

    void editStatus(String clOrdId, int estatus) throws Exception;
    void editStatusNos(String clOrdId, int estatus) throws Exception;
    int editStatusNos(List<String> clOrdIdList, int estatus) throws SQLException;

    void editStatusOcr(String clOrdId, int estatus) throws SQLException;
    int editStatusOcr(List<String> clOrdIdList, int estatus) throws SQLException;

    void updateStatus(List<String> clOrdIdListNos, List<String> clOrdIdListOcr, final int estatus);
    int updateStatusSync(List<String> clOrdIdList, int estatus) throws SQLException;
    int updateStatusAck2Sync(EstatusAck2InfoBatch estatusAck2InfoBatch) throws SQLException;

    void editStatus(String clOrdId, int estatus, int estatusAck2, String descrAck2) throws Exception;

    void createError(ErroresEntity erroresEntity) throws Exception;

    void createErrorUpdateEstatus(String errorMsg, Throwable t, Object fixMsg);

    void moveToHistoricDB();
}
