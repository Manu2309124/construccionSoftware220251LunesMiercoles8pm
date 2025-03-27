package app.adapters.invoice.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.adapters.invoice.entity.InvoiceEntity;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

    List<InvoiceEntity> findByOwnerId(Long ownerId);

    List<InvoiceEntity> findByPetId(Long petId);

    List<InvoiceEntity> findByOrderId(Long orderId);

    List<InvoiceEntity> findByDate(Date date);
}