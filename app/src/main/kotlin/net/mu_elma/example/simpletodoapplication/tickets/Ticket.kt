package net.mu_elma.example.simpletodoapplication.tickets

import java.util.*

/**
 * Created by muratomo on 2017/07/08.
 */

// ToDo詳細 Ticketという名前で管理
data class Ticket(
        val todoNumber: Int,
        val title: String,
        val status: TicketStatus,
        val priority: TicketPriority,
        val limit: Date,
        val content: String
)