package com.home.rent.service.myservice.serviceImpl;

import com.home.rent.service.myservice.entity.User;
import com.home.rent.service.myservice.exceptions.InvalidOperationException;
import com.home.rent.service.myservice.repository.UserRepository;
import com.home.rent.service.myservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user)  {

        return userRepository.save(user);
    }

    @Override
    public User update(User user) throws Exception {
        if (user.hasId()) {
            return save(user);
        } else {
            throw new InvalidOperationException("User id required for update operation");
        }
    }

    @Override
    public Page<User> getByIds(Pageable pageable, Long... ids) {
        if(ids==null || (ids.length < 1)){
            return getAll(pageable);
        }else {
            return userRepository.getByIds(Arrays.asList(ids),
                    pageable);
        }
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void deleteByIds(Long... ids) {
    userRepository.deleteAllByIdInBatch(Arrays.asList(ids));
    }
}
