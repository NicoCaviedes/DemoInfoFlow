package com.quatrosphere.apipublica.models.sales;

import com.quatrosphere.apipublica.models.base.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ventas_comercio")
@Data @ToString
public class SaleModel extends BaseModel {

    @Id
    @Column(name = "id_sale")
    private long idSale;

    @Column(name = "tot_prods")
    private long totProds;

    @Column(name = "total_price_sale")
    private long totalPriceSale;

    @OneToMany(mappedBy = "saleProduct")
    private List<DetailSaleModel> detailSale;

    @Override
    public SaleModelDto transferToDto(){
        SaleModelDto saleTrf = new SaleModelDto();

        saleTrf.setIdSale(this.idSale);
        saleTrf.setTotProds(this.totProds);
        saleTrf.setTotalPriceSale(this.totalPriceSale);
        saleTrf.setDetailSale(transferDetailSale());

        return saleTrf;
    }

    public List<DetailSaleModelDto> transferDetailSale(){
        List<DetailSaleModelDto> listDetail = new ArrayList();
        detailSale.forEach(detailSaleModel -> {
            listDetail.add(detailSaleModel.transferToDto());
        });

        return listDetail;
    }
}
