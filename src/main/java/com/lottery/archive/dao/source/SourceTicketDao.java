package com.lottery.archive.dao.source;

import com.lottery.archive.entity.source.SourceTicket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sahinn
 * @date 16/6/16
 */
public interface SourceTicketDao extends JpaRepository<SourceTicket,String> {
}
