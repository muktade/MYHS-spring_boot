package com.home.rent.service.myservice.serviceImpl;

import com.home.rent.service.myservice.entity.Reply;
import com.home.rent.service.myservice.entity.User;
import com.home.rent.service.myservice.exceptions.InvalidOperationException;
import com.home.rent.service.myservice.repository.ReplyRepository;
import com.home.rent.service.myservice.repository.UserRepository;
import com.home.rent.service.myservice.service.ReplyService;
import com.home.rent.service.myservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    @Override
    public Reply save(Reply reply)  {

        return replyRepository.save(reply);
    }

    @Override
    public Reply update(Reply reply) throws Exception {
        if (reply.hasId()) {
            return save(reply);
        } else {
            throw new InvalidOperationException("Reply id required for update operation");
        }
    }

    @Override
    public Page<Reply> getByIds(Pageable pageable, Long... ids) {
        if(ids==null || (ids.length < 1)){
            return getAll(pageable);
        }else {
            return replyRepository.getByIds(Arrays.asList(ids),
                    pageable);
        }
    }

    @Override
    public Page<Reply> getAll(Pageable pageable) {

        return replyRepository.findAll(pageable);
    }

    @Override
    public void deleteByIds(Long... ids) {

        replyRepository.deleteAllByIdInBatch(Arrays.asList(ids));
    }
}
