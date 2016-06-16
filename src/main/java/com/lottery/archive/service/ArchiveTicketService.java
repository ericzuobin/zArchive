package com.lottery.archive.service;

import com.lottery.archive.entity.archive.ArchiveTicket;
import com.lottery.archive.entity.source.SourceTicket;

/**
 * @author Sahinn
 * @date 16/6/16
 */
public interface ArchiveTicketService {

    void save(SourceTicket sourceTicket);

    void delete(SourceTicket sourceTicket);

    void update(SourceTicket sourceTicket);

    ArchiveTicket findById(String id);
}
