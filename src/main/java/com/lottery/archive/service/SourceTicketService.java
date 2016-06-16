package com.lottery.archive.service;

import com.lottery.archive.entity.source.SourceTicket;

/**
 * @author Sahinn
 * @date 16/6/16
 */
public interface SourceTicketService {

    void save(SourceTicket sourceTicket);

    void delete(SourceTicket sourceTicket);

    void update(SourceTicket sourceTicket);

    SourceTicket findById(String id);
}
