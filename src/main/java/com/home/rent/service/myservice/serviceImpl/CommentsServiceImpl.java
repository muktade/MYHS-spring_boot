package com.home.rent.service.myservice.serviceImpl;

import com.home.rent.service.myservice.entity.Comments;
import com.home.rent.service.myservice.entity.User;
import com.home.rent.service.myservice.exceptions.InvalidOperationException;
import com.home.rent.service.myservice.repository.CommentsRepository;
import com.home.rent.service.myservice.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    @Override
    public Comments save(Comments comments)  {

        return commentsRepository.save(comments);
    }

    @Override
    public Comments update(Comments comments) throws Exception {
        if (comments.hasId()) {
            return save(comments);
        } else {
            throw new InvalidOperationException("Comments id required for update operation");
        }
    }

    @Override
    public Page<Comments> getByIds(Pageable pageable, Long... ids) {
        if(ids==null || (ids.length < 1)){
            return getAll(pageable);
        }else {
            return commentsRepository.getByIds(Arrays.asList(ids),
                    pageable);
        }
    }

    @Override
    public Page<Comments> getAll(Pageable pageable) {

        return commentsRepository.findAll(pageable);
    }

    @Override
    public void deleteByIds(Long... ids) {

        commentsRepository.deleteAllByIdInBatch(Arrays.asList(ids));
    }
}
