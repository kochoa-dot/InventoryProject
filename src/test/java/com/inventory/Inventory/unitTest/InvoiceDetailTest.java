package com.inventory.Inventory.unitTest;

import com.inventory.Inventory.exception.DetailNotFoundException;
import com.inventory.Inventory.model.InvoiceDetail;
import com.inventory.Inventory.repository.InvoiceDetailRepository;
import com.inventory.Inventory.service.InvoiceDetailServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InvoiceDetailTest {

    @Mock
    private InvoiceDetailRepository invoiceDetailRepository;

    @InjectMocks
    private InvoiceDetailServiceImpl invoiceDetailService;

    @Test
    public void testGetInvoiceDetailById() {
        // given
        Long id = 1L;
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        invoiceDetail.setId_invoiced(id);
        invoiceDetail.setInvoice_number("INV-001");
        invoiceDetail.setQuantity(10);
        invoiceDetail.setSubtotal(100.0);

        when(invoiceDetailRepository.findById(id)).thenReturn(Optional.of(invoiceDetail));

        // when
        InvoiceDetail result = invoiceDetailService.getInvoiceDetailById(id);

        // then
        assertEquals(id, result.getId_invoiced());
        assertEquals("INV-001", result.getInvoice_number());
        assertEquals(10, result.getQuantity());
        assertEquals(100.0, result.getSubtotal());

        verify(invoiceDetailRepository, times(1)).findById(id);
    }

    @Test
    public void testGetInvoiceDetailByIdNotFound() {
        // given
        Long id = 1L;
        when(invoiceDetailRepository.findById(id)).thenReturn(Optional.empty());

        // when, then
        assertThrows(DetailNotFoundException.class, () -> {
            invoiceDetailService.getInvoiceDetailById(id);
        });

        verify(invoiceDetailRepository, times(1)).findById(id);
    }
}
