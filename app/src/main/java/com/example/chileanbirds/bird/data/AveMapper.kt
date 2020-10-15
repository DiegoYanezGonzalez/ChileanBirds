package com.example.chileanbirds.bird.data

import com.example.chileanbirds.bird.domain.model.Ave

class AveMapper {
    fun mapToEntity(aveModel: AveModel) : Ave {
        aveModel.apply {
            return Ave(uid,name,images,links ,sort)
        }
    }
}