package com.lottery.archive.controler;

import com.lottery.archive.entity.archive.ArchiveTicket;
import com.lottery.archive.entity.source.SourceTicket;
import com.lottery.archive.service.ArchiveTicketService;
import com.lottery.archive.service.SourceTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sahinn
 * @date 16/6/16
 */
@RestController
@RequestMapping("/testrest")
public class TestControler {

    @Autowired
    private SourceTicketService sourceTicketService;

    @Autowired
    private ArchiveTicketService archiveTicketService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String helloWorld(){

        SourceTicket sourceTicket = sourceTicketService.findById("1151003000000034838");

        System.out.println(sourceTicket.getBatchId());

        ArchiveTicket archiveTicket  =archiveTicketService.findById("1151003000000034849");



        return  sourceTicket.getBatchId() + "+" + archiveTicket.getBatchId();
    }
}
