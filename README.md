這是一個由springboot init產製的專案。
為了要測試springdoc與全域異常攔截的問題。

問題點如下：
- 在filter/GlobalExceptionHandler內使用@RestControllerAdvice會導致springdoc失效。
- 上面註解註釋掉後，確定可正常運行。