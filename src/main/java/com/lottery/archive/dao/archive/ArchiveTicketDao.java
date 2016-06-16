package com.lottery.archive.dao.archive;

import com.lottery.archive.entity.archive.ArchiveTicket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sahinn
 * @date 16/6/16
 */

public interface ArchiveTicketDao extends JpaRepository<ArchiveTicket,String> {
}
