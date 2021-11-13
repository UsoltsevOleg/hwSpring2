package springbootapp.controllers;

import com.example.boot.starter.services.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapp.entities.Car;
import springbootapp.repositories.SteeringWheelRepository;
import springbootapp.service.SteeringWheelService;
import springbootapp.service.serviceimpl.CarServiceImpl;
import springbootapp.service.serviceimpl.*;

import java.util.Optional;

@RestController
public class SteeringWheelController {

    @Autowired
    private SteeringWheelRepository steeringWheelRepository;

    @Autowired
    private SteeringWheelServiceImpl steeringWheelService;

    @RequestMapping(value = "/api/steeringWheel/read/{id}", method = RequestMethod.GET)
    public Optional<SteeringWheelService> getSteeringWheelService(long id) {
        Optional<SteeringWheelService> steeringWheel = steeringWheelService.getByID(id);
        return steeringWheel;
    }

    @RequestMapping(value = "/api/steeringWheel/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateSteeringWheelService(@RequestBody SteeringWheelService steeringWheel) {
        return new ResponseEntity<>(steeringWheelService.update(steeringWheel), HttpStatus.UPGRADE_REQUIRED);
    }

    @RequestMapping(value = "/api/steeringWheel/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteSteeringWheelService(@PathVariable long id) {
        Optional<SteeringWheelService> steeringWheel = steeringWheelRepository.getByID(id);
        steeringWheelService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/steeringWheel/create", method = RequestMethod.POST)
    public ResponseEntity<?> createSteeringWheelService(@RequestBody SteeringWheelService steeringWheelService) {
        return new ResponseEntity<>(steeringWheelService.save(steeringWheel), HttpStatus.CREATED);
    }
}