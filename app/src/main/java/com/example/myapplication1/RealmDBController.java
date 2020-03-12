package com.example.myapplication1;
import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class RealmDBController {
    ArrayList<RowDataModel> dataModels;

      public Realm RealmDBController(Context c){
      Realm.init(c);
       Realm realm = Realm.getDefaultInstance();

          if(!realm.isEmpty()){
              dataModels= new ArrayList<>();
              RealmResults<RowDataModel> data = realm.where(RowDataModel.class).findAll();
              for(int i=0;i<data.size();i++){
                  dataModels.add(data.get(i));
              }
          }


       return realm;
    }
public void fillingDB(Realm realm, Context c, List<RowDataModel> s){
    if(realm.isEmpty()){
        realm.beginTransaction();
        dataModels= new ArrayList<>();
        for(int i=0;i<s.size();i++){
            dataModels.add(s.get(i));
            realm.copyToRealm(dataModels.get(i));
        }
        realm.commitTransaction();
    }
}
public void addItem(Realm realm, Context c, RowDataModel item){
    RowDataModel temp = item;
    dataModels.add(temp);
    realm.beginTransaction();
    realm.copyToRealm(temp);
    realm.commitTransaction();
}
public void deleteItem(Realm realm,Context c,int num){
    realm.beginTransaction();
    final RealmResults<RowDataModel> data = realm.where(RowDataModel.class).findAll();
    data.deleteFromRealm(num);
    realm.commitTransaction();
}
public void updateItem(Realm realm, Context c, final int num, final RowDataModel item){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(item);
            }
        });
}
public ArrayList<RowDataModel> readAll(Realm realm, Context c){
    RealmResults<RowDataModel> result = realm.where(RowDataModel.class).findAll();
    ArrayList<RowDataModel> temp = new ArrayList<>();
    for(int i=0;i<result.size();i++){
        temp.add(result.get(i));
    }
    return temp;
}
public RowDataModel readItem(Realm realm,Context c,String num){
    RowDataModel data = realm.where(RowDataModel.class).equalTo("companyName", num).findFirst();
return data;
}
}
