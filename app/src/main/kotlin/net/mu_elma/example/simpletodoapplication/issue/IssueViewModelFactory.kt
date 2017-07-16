package net.mu_elma.example.simpletodoapplication.issue

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import net.mu_elma.example.simpletodoapplication.ToDoRepository

/**
 * Created by muratomo on 2017/07/16.
 */
class IssueViewModelFactory(val todoRepository: ToDoRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>?): T {
        return IssueViewModel(todoRepository) as T
    }
}