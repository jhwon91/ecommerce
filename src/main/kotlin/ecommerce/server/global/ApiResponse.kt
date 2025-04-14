package ecommerce.server.global

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "공통 응답 DTO")
data class ApiResponse<T>(
    @Schema(description = "응답 코드")
    val code: Int,

    @Schema(description = "응답 메시지", example = "null")
    val message: String?,

    @Schema(description = "응답 데이터")
    val data: T?
)