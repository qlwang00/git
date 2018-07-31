package example.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import example.dao.UserDao;
import example.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    public static final String SECRET="java-jwt";
    public String createToken(String id,String name){
        Map<String,Object> mapHeader=new HashMap<>();
        mapHeader.put("alg", "HS256");
        mapHeader.put("typ", "JWT");
        String token=JWT.create()
                .withHeader(mapHeader)
                .withClaim("iss", "Service") // payload
                .withClaim("aud", "APP")
                .withClaim("id",id)
                .withClaim("name",name)
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }
    public Map<String,String> veifyToken(String token){
        final Map<String,String> resmap=new HashMap<>();

        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String id=jwt.getClaims().get("id").asString();
        String name=jwt.getClaims().get("name").asString();
        resmap.put("id",id);
        resmap.put("name",name);

        return resmap;
    }

    @Autowired
    private UserDao dao;

    public List<User> getUsers(){
        return dao.getUsers();
    }

    public int Add(User us){
        return dao.addUser(us);
    }

    public void Delete(String id){
        dao.deleteUser(id);
    }

    public List<User> findUser(String id){
        return dao.findUserById(id);
    }

    public void update(User us){
        dao.updateUser(us);
    }

}
