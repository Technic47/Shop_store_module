package ru.kuznetsov.shop.store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kuznetsov.shop.data.service.StockService;
import ru.kuznetsov.shop.data.service.StoreService;
import ru.kuznetsov.shop.represent.dto.AddressDto;
import ru.kuznetsov.shop.represent.dto.StockDto;
import ru.kuznetsov.shop.represent.dto.StoreDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final StockService stockService;

    @GetMapping("/{id}")
    public ResponseEntity<StoreDto> getStoreById(@PathVariable Long id) {
        return ResponseEntity.ok(storeService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<StoreDto>> getAllStores(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long addressId
    ) {
        List<StoreDto> storeList = new ArrayList<>();

        if (id != null) {
            storeList.add(storeService.findById(id));
        } else if (name != null) {
            storeList.add(storeService.findByName(name));
        } else if (addressId != null) {
            storeList.addAll(storeService.findByAddressId(addressId));
        } else storeList.addAll(storeService.findAll());

        return ResponseEntity.ok(storeList);
    }

    @GetMapping("/{id}/stock")
    public ResponseEntity<List<StockDto>> getAllStockByStoreId(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.findAllByStoreId(id));
    }

    @PostMapping
    public ResponseEntity<StoreDto> createStore(@RequestBody StoreDto storeDto) {
        return ResponseEntity.ok(storeService.add(storeDto));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<StoreDto>> createBatch(@RequestBody Collection<StoreDto> dtoCollection) {
        return ResponseEntity.ok(dtoCollection.stream()
                .map(storeService::add)
                .toList());
    }

    @DeleteMapping("/{id}")
    public void deleteeStore(@PathVariable Long id) {
        storeService.deleteById(id);
    }
}
