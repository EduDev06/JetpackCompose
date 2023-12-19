package com.example.jetpackcompose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ContactsUiState(
    val contact: List<Contact> = fakeContacts
)

interface SortStrategy {
    fun sort(contacts: List<Contact>): List<Contact>
}

class AgeSort: SortStrategy {
    override fun sort(contacts: List<Contact>): List<Contact> {
        return contacts.sortedBy { it.age }
    }
}

class NameSort: SortStrategy {
    override fun sort(contacts: List<Contact>): List<Contact> {
        return contacts.sortedBy { it.name }
    }
}

class MainViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(ContactsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        updateContacts(AgeSort())
    }

    fun updateContacts(sortStrategy: SortStrategy) {
        _uiState.update {
            it.copy(contact = sortStrategy.sort(_uiState.value.contact))
        }
    }
}