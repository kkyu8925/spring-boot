package com.sparta.selectshop.service;

import com.sparta.selectshop.dto.ItemDto;
import com.sparta.selectshop.dto.ProductRequestDto;
import com.sparta.selectshop.model.Product;
import com.sparta.selectshop.dto.ProductMypriceRequestDto;
import com.sparta.selectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Service // 서비스임을 선언합니다.
public class ProductService {
    // 멤버 변수 선언
    private final ProductRepository productRepository;
    private static final int MIN_PRICE = 100;

    // 회원 ID 로 등록된 모든 상품 조회
    public List<Product> getProducts(Long userId) {
        return productRepository.findAllByUserId(userId);
    }

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Product createProduct(ProductRequestDto requestDto, Long userId) {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto, userId);
        productRepository.save(product);
        return product;
    }

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        int myPrice = requestDto.getMyprice();
        if (myPrice < MIN_PRICE) {
            throw new IllegalAccessError("희망 최저가는 100이하가 될 수 없습니다.");
        }

        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        product.updateMyPrice(requestDto);
        return product.getId();
    }

    /**
     * utils.Scheduler 에서 사용
     */
    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long updateBySearch(Long id, ItemDto itemDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        product.updateByItemDto(itemDto);
        return product.getId();
    }

    // 모든 상품 조회 (관리자용)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
