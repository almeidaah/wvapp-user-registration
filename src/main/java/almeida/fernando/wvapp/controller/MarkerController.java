package almeida.fernando.wvapp.controller;

import almeida.fernando.wvapp.model.Marker;
import almeida.fernando.wvapp.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*") //Already added in WebSecurity - keeping just in case :)
@RequestMapping("/markers")
public class MarkerController {

    @Autowired
    MarkerService markerService;

    @PostMapping("/{userId}")
    public ResponseEntity<Marker> addMarker(@PathVariable String userId, @RequestBody Marker marker){
        try {
            markerService.save(userId, marker);
            return new ResponseEntity<>(marker, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(new Marker(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
