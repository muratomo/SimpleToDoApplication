package net.mu_elma.example.simpletodoapplication.issue

import android.arch.lifecycle.*
import net.mu_elma.example.simpletodoapplication.ToDoRepository

/**
 * Created by muratomo on 2017/07/16.
 */
class IssueViewModel(repository: ToDoRepository) : ViewModel() {
    private val issueIds = MutableLiveData<List<Int>>()
    val issues: LiveData<List<Issue>> = Transformations.switchMap(issueIds) {
        ids -> if (ids.isEmpty()) {
            repository.getAllIssues()
        } else {
            repository.getAllIssues()
        }
    }

    // 発火確認するためのテスト関数
    fun testSet(num: Int) {
        val new = listOf<Int>(num)
        val old = issueIds.value
        if (old != null) {
            issueIds.value = old + new
        } else {
            issueIds.value = new
        }
    }
}