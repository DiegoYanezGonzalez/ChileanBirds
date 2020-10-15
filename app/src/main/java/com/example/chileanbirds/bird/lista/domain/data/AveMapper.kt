package com.example.chileanbirds.bird.lista.domain.data

import com.example.chileanbirds.bird.lista.domain.model.Ave

class AveMapper {
    fun mapToEntity(aveModel: AveModel) : Ave {
        aveModel.apply {
            return Ave(uid,name,images,links ,sort)
        }
    }
}