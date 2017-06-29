package com.example.supun.molly.Service;

import android.util.Log;


import com.example.supun.molly.Model.PaymentModel;
import com.example.supun.molly.Model.QrModel;

import java.util.ArrayList;

/**
 * Created by supun on 29/06/17.
 */

public class QrCodeSplite {
    private static QrCodeSplite instance;
    private QrCodeSplite(){
    }
    public static QrCodeSplite getInstance(){
        if(instance == null){
            instance = new QrCodeSplite();
        }
        return  instance;
    }
    public PaymentModel spliteQrCode(String code){
        PaymentModel paymentModel = new PaymentModel();
        ArrayList<QrModel> qrModels =  new ArrayList<>();
        code = code.trim();
        String models[] = code.split(";");
        for (String model: models) {
            Log.d("splite",model);
            model = model.trim();
            String params[] = model.split(" ");

            QrModel qrModel = new QrModel();

            qrModel.setId(params[0]);
            if(params[1].equals("$") && params[2].equals("main")){
                paymentModel.setDynamic(false);
            }
            else {
                paymentModel.setDynamic(true);
                qrModel.setAmount(params[1]);
            }
            qrModel.setTag(params[2]);
            if (params[2].equals("tip")){
                paymentModel.setTip(true);

            }
            else {
                paymentModel.setTip(false);
            }

            int size = params.length;
            if(size>3){
                ArrayList<String> customParams = new ArrayList<>();
                for (int i=3;i<size;i++){
                    customParams.add(params[i]);
                }
                qrModel.setCustomTypes(customParams);
                qrModel.setHaveCustomTypes(true);
            }
            else {
                qrModel.setHaveCustomTypes(false);
            }
            Log.d("qrmodel",qrModel.toString());
            qrModels.add(qrModel);
        }
        paymentModel.setQrModels(qrModels);
        return paymentModel;
    }


}
