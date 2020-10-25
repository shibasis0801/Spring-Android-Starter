package com.overlord.server

import com.overlord.common.DiagnosticsRoute.Contract
import com.overlord.common.DiagnosticsRoute.Config
import com.overlord.common.Hello
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping("/${Config.BASE}")
class DiagnosticsController: Contract {

    @GetMapping("/${Config.HELLO}")
    override suspend fun helloWorld() = Hello("Hello From Spring")

}