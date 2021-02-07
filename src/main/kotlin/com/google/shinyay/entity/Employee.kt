package com.google.shinyay.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Employee(@Id val id: Long,
                    val firstName: String,
                    val lastName: String,
                    val role: String)