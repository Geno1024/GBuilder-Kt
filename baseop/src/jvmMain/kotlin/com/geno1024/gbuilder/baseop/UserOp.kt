package com.geno1024.gbuilder.baseop

import com.geno1024.gbuilder.db.structures.User

class UserOp
{
    fun getUser()
    {
        for (field in User.fields)
        {
            println(field)
        }
    }
}
