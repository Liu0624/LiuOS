package com.example.liuos.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
@ApiModel
public class DeleteUserByIdsForm {
    @NotEmpty(message = "ids不能为空")
    private Integer[] ids;
}