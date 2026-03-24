package ru.kuznetsov.shop.store.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuznetsov.shop.represent.dto.StoreDto;

import java.util.Collection;
import java.util.List;

public interface StoreControllerApi {

    @Operation(summary = "Поиск по id", description = "Получение сущности по id записи")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StoreDto.class)
                    ),
                    description = "Склад"
            ),
            @ApiResponse(responseCode = "204",
                    content = @Content(
                            schema = @Schema(hidden = true)
                    ),
                    description = "Склад не найден")
    })
    ResponseEntity<StoreDto> getStoreById(
            @Parameter(description = "Уникальный идентификатор склада для поиска", required = true,
                    schema = @Schema(
                            description = "Id склада",
                            example = "123",
                            type = "integer",
                            format = "int64"
                    )
            )
            @PathVariable Long id);

    @Operation(summary = "Получение всех сущностей", description = "Получение всех сущностей")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StoreDto[].class)
                    ),
                    description = "Список складов"
            ),
            @ApiResponse(
                    responseCode = "204",
                    content = @Content(
                            schema = @Schema(hidden = true)
                    ),
                    description = "Складов не найдено"
            )
    })
    ResponseEntity<List<StoreDto>> getAllStores(
            @Parameter(description = "Уникальный идентификатор склада для поиска",
                    schema = @Schema(
                            description = "Id склада",
                            example = "123",
                            type = "integer",
                            format = "int64"
                    )
            )
            @RequestParam(required = false) Long id,
            @Parameter(description = "Наименование склада для поиска",
                    schema = @Schema(
                            description = "Наименование склада",
                            example = "Центральный"
                    )
            )
            @RequestParam(required = false) String name,
            @Parameter(description = "Уникальный идентификатор адреса склада для поиска",
                    schema = @Schema(
                            description = "Id склада",
                            example = "123",
                            type = "integer",
                            format = "int64"
                    )
            )
            @RequestParam(required = false) Long addressId,
            @Parameter(description = "Уникальный идентификатор владельца склада для поиска",
                    schema = @Schema(
                            description = "Id владельца (uuid)",
                            example = "95381fbe-b068-4e88-abf5-85e96f64f507"
                    )
            )
            @RequestParam(required = false) String ownerId
    );

    @Operation(summary = "Создание склада", description = "Создание склада")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StoreDto.class)
                    ),
                    description = "Сущность создана"
            ),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(
                            schema = @Schema(hidden = true)
                    ),
                    description = "Не корректно указаны данные"
            )
    })
    ResponseEntity<StoreDto> createStore(
            @Parameter(description = "Модель склада для создания", required = true,
                    schema = @Schema(
                            implementation = StoreDto.class,
                            description = "Склад"
                    ))
            @RequestBody StoreDto storeDto);

    @Operation(summary = "Создание нескольких складов", description = "Единовременное создание нескольких сущностей")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StoreDto[].class)
                    ),
                    description = "Сущность создана"
            ),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(
                            schema = @Schema(hidden = true)
                    ),
                    description = "Не корректно указаны данные"
            )
    })
    ResponseEntity<List<StoreDto>> createBatch(
            @Parameter(description = "Модель склада для создания", required = true,
                    schema = @Schema(
                            implementation = StoreDto[].class,
                            description = "Склад"
                    ))
            @RequestBody Collection<StoreDto> dtoCollection);

    @Operation(summary = "Обновление склада", description = "Обновление склада")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StoreDto.class)
                    ),
                    description = "Сущность обновлена"
            ),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(
                            schema = @Schema(hidden = true)
                    ),
                    description = "Не корректно указаны данные"
            )
    })
    ResponseEntity<StoreDto> updateStore(
            @Parameter(description = "Модель склада для обновления", required = true,
                    schema = @Schema(
                            implementation = StoreDto.class,
                            description = "Склад"
                    ))
            @RequestBody StoreDto storeDto);

    @Operation(summary = "Удаление по id", description = "Удаление сущности по id записи")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Склад удалён"),
            @ApiResponse(responseCode = "404", description = "Склад не найден")
    })
    void deleteStore(
            @Parameter(description = "Уникальный идентификатор склада для удаления", required = true,
                    schema = @Schema(
                            description = "Id склада",
                            example = "123",
                            type = "integer",
                            format = "int64"
                    )
            )
            @PathVariable Long id);
}
