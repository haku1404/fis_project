package criminal.repository;


import criminal.core.TrackAction;
import criminal.model.TrackEntry;

import java.util.Date;
import java.util.Set;

public interface TrackEntryRepo extends AbstractRepo<TrackEntry> {

    Set<TrackEntry> findByDetectiveId(Long detectiveId);
    Set<TrackEntry> findByEvidenceId(Long evidenceId);
    Set<TrackEntry> findByDate(Date date);
    Set<TrackEntry> findByDateAndAction(Date date, TrackAction action);
}
