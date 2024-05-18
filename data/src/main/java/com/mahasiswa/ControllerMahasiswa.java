package com.mahasiswa;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mahasiswa")
public class ControllerMahasiswa {
    @GET
    @Path("/data")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ModelMahasiswa>getData()
        throws ClassNotFoundException{
            ArrayList<ModelMahasiswa> mm = new ArrayList<>();

            int[] id = {101,102};
            String[] nama = {"Budi","Adi"};

            for (int i = 0; i < nama.length; i++) {
                ModelMahasiswa mm2 = new ModelMahasiswa();
                mm2.setId(id[i]);
                mm2.setNama(nama[i]);
                mm.add(mm2);
            }
        return mm;
        }

    @POST
    @Path("/postData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response inputData(ModelMahasiswa tm){
        String result = "Data Sudah Masuk : "+tm.getNama()+"(id :"+tm.getId()+")";
        return Response.status(201).entity(result).build();
    }

    @POST
    @Path("/testData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cekData(ModelMahasiswa mh){
        String result;

        if (mh.getId()==123 && mh.getNama().equals("faiz")) {
            result = "Sukses";
        }else{
            result = "Gagal";
        }
        return Response.status(201).entity(result).build();
    }


}
