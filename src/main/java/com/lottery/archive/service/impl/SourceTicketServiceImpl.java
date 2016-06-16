package com.lottery.archive.service.impl;

import com.lottery.archive.dao.source.SourceTicketDao;
import com.lottery.archive.entity.source.SourceTicket;
import com.lottery.archive.service.SourceTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sahinn
 * @date 16/6/16
 */
@Service
@Transactional("sourceTransactionManager")
public class SourceTicketServiceImpl implements SourceTicketService{

    @Autowired
    private SourceTicketDao sourceTicketDao;

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
    public SourceTicket findById(String id) {

        SourceTicket ticket = sourceTicketDao.findOne(id);
        return ticket;
    }
}
