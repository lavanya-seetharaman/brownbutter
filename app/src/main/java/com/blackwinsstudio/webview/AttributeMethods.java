package com.blackwinsstudio.webview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface AttributeMethods {

    @GET("wc/v3/products/attributes/2/terms")
    Call<List<AttributesModel>> getMachineInPlaceData( @Header("Authorization") String authkey);

    @GET("wc/v3/orders")
    Call<List<OrdersModel>> getAllOrders(@Header("Authorization") String authkey);

    @FormUrlEncoded
    @POST("wc/v3/products/{id}")
    Call<ProductInformation> postProductQty(@Header("Authorization") String authkey, @Path("id")String id,@Field ("stock_quantity") int stockQty);

    @GET("wc/v3/products")
    Call<List<ProductInformation>> getProduct(@Header("Authorization") String authkey);

    @GET("custom-apis")
    Call<OrderedItemModel> getOrderedItems(@Header("Authorization") String authkey);

    @FormUrlEncoded
    @POST("custom-apis")
    Call<OrderedItemModel> postOrderedItems(@Field ("OrderID")int order_id,
                                            @Field ("Status") String status,
                                            @Field("ProductID") int product_id,
                                            @Field("Qty") int quantity,
                                            @Field("Options")String options);

    @GET("api/user-vendors")
    Call<VendorUserModel> getVendorLoginUser();
}
