package com.example.liuos.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.*;

//@Schema(description = "修改用户信息表单")
@Data
@ApiModel
public class SearchUserByIdForm {

    @NotNull(message = "userId不能为空")
    @Min(value = 1, message = "userId不能小于1")
    private Integer userId;
}
