package net.serlith.zluket.controllers

import jakarta.servlet.RequestDispatcher
import jakarta.servlet.http.HttpServletRequest
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ErrorController : ErrorController {

    @RequestMapping("/error")
    fun catchError(request: HttpServletRequest): String {
        val status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE) ?: return "errors/404"
        val code = status.toString().toInt()
        if (code == 400) return "errors/400"
        return "errors/404"
    }

}