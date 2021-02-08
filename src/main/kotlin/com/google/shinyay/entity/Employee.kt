package com.google.shinyay.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Employee(@Id @GeneratedValue var id: Long,
                    var firstName: String,
                    var lastName: String,
                    var role: String)