package net.mu_elma.example.simpletodoapplication

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import net.mu_elma.example.simpletodoapplication.tickets.Ticket
import net.mu_elma.example.simpletodoapplication.tickets.TicketPriority
import net.mu_elma.example.simpletodoapplication.tickets.TicketStatus
import java.util.*

/**
 * Created by muratomo on 2017/07/09.
 */
object ToDoRepository {
    fun getTickets(issueNum: Int) : LiveData<List<Ticket>> {
        val tickets = MutableLiveData<List<Ticket>>()
        tickets.value = mutableListOf<Ticket>().apply {
            when(issueNum) {
                0 -> {
                    add(Ticket(issueNum, "First", TicketStatus("Issue"), TicketPriority(0), Date(), "content 1"))
                    add(Ticket(issueNum, "Second", TicketStatus("Doing"), TicketPriority(3), Date(), "content 2"))
                }
                1 -> {
                    add(Ticket(issueNum, "hoge", TicketStatus("Issue"), TicketPriority(1), Date(), "Hoge"))
                    add(Ticket(issueNum, "foo", TicketStatus("Done"), TicketPriority(1), Date(), "Foo"))
                }
                else -> {
                    add(Ticket(issueNum, "other", TicketStatus("chancel"), TicketPriority(0), Date(), "other"))
                }
            }
        }
        return tickets
    }

    fun getAllIssues() : LiveData<List<Issue>> {
        val issues = MutableLiveData<List<Issue>>()
        issues.value = mutableListOf<Issue>().apply {
            add(Issue(0))
            add(Issue(1))
            add(Issue(2))
        }
        return issues
    }
}