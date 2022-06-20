package criminal.repository;

import criminal.model.entity.TrackEntry;
import criminal.model.enums.TrackAction;

import java.util.Date;
import java.util.Set;

public interface TrackEntryRepo extends AbstractRepo<TrackEntry> {

    Set<TrackEntry> findByDetectiveId(Long detectiveId);
    Set<TrackEntry> findByEvidenceId(Long evidenceId);
    Set<TrackEntry> findByDate(Date date);
    Set<TrackEntry> findByDateAndAction(Date date, TrackAction action);
}
