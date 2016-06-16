package com.lottery.archive.service.impl;

import com.lottery.archive.dao.archive.ArchiveTicketDao;
import com.lottery.archive.entity.archive.ArchiveTicket;
import com.lottery.archive.entity.source.SourceTicket;
import com.lottery.archive.service.ArchiveTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sahinn
 * @date 16/6/16
 */
@Service
@Transactional("archiveTransactionManager")
public class ArchiveTicketServiceImpl implements ArchiveTicketService{

    @Autowired
    private ArchiveTicketDao archiveTicketDao;

    @Override
    public void save(SourceTicket sourceTicket) {

    }

    @Override
    public void delete(SourceTicket sourceTicket) {

    }

    @Override
    public void update(SourceTicket sourceTicket) {

    }

    @Override
    public ArchiveTicket findById(String id) {

        ArchiveTicket ticket = archiveTicketDao.findOne(id);

        return ticket;
    }
}
