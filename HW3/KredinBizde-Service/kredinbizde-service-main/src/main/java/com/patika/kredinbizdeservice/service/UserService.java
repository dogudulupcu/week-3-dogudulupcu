package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.producer.NotificationProducer;
import com.patika.kredinbizdeservice.producer.dto.NotificationDTO;
import com.patika.kredinbizdeservice.producer.enums.NotificationType;
import com.patika.kredinbizdeservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService  {

    private UserRepository userRepository = new UserRepository();
    
    private final NotificationProducer notificationProducer;


    public User save(User user) {
        System.out.println("userRepository: " + userRepository.hashCode());
        userRepository.save(user);
        
        notificationProducer.sendNotification(prepareNotificationDTO((NotificationType.MOBILE_NOTIFICATION),user.getEmail()));
        return user;
    }

    private NotificationDTO prepareNotificationDTO(NotificationType notificationType, String email) {
        return NotificationDTO.builder()
                .message("user kaydedildi")
                .notificationType(notificationType)
                .userEmail(email)
                .build();
    }


    public List<User> getAll() {
        System.out.println("userRepository: " + userRepository.hashCode());
        return userRepository.getAll();
    }


    public User getByEmail(String email) {

        Optional<User> foundUser = userRepository.findByEmail(email);

        User user = null;

        //User user = foundUser.orElseThrow(RuntimeException::new);

        if (foundUser.isPresent()) {
            user = foundUser.get();
        }

        return user;

    }


    public User update(String email, User user) {
        Optional<User> foundUser = userRepository.findByEmail(email);
        if(foundUser.isPresent()){
            foundUser.get().setName(user.getName());

            foundUser.get().setSurname(user.getSurname());

            userRepository.delete(user);

            userRepository.save(foundUser.get());

            return foundUser.get();
        }

        return null;
    }

    public User getById(long id){
        Optional<User> foundUser = userRepository.findById(id);
        User user = null;

        if (foundUser.isPresent()) {
            user = foundUser.get();
        }

        return user;
    }
}
