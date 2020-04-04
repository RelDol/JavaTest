package vn.anhnhb.javatestapi.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.anhnhb.javatestapi.exception.ApiException;
import vn.anhnhb.javatestapi.model.Work;
import vn.anhnhb.javatestapi.repository.WorkRepository;

/**
 * Handle execute work
 * @author AnhNHB
 * @version 1.0 2020/04/03
 *
 */
@RestController
@RequestMapping("api")
public class WorkController {

	/**
	 * work information
	 */
	private Work workInfo;

	/**
	 * workRepository
	 */
	@Autowired
	private WorkRepository workRepository;

	/**
	 * handle add new work
	 * @param wrk work information request from request
	 * @return Object Work
	 */
	@PostMapping("addwork")
	public Work addWork(@Valid @RequestBody Work wrk) {
		return workRepository.save(wrk);
	}

	/**
	 * handle update/edit work information by ID
	 * @param workId work_id
	 * @param workReq work information request from request
	 * @return ResponseEntity<Work> work information update completed
	 * @throws ApiException exception handle error
	 */
	@PutMapping("updatework/{id}")
	public ResponseEntity<Work> updateWork(@PathVariable(value = "id") Integer workId,
			@Valid @RequestBody Work workReq) throws ApiException {
		
		// check valid work_id exists
		validate(workId);

		// set data in Work Object
		workInfo.setWorkName(workReq.getWorkName());
		workInfo.setStartDate(workReq.getStartDate());
		workInfo.setEndDate(workReq.getEndDate());
		workInfo.setStatus(workReq.getStatus());
		
		// update information form Database
		final Work updateWork = workRepository.save(workInfo);
		
		return ResponseEntity.ok(updateWork);
	}

	/**
	 * handle delete work information by ID
	 * @param workId work_id
	 * @return OK: {deleted: true}
	 * @throws ApiException exception handle error
	 */
	@DeleteMapping("deletework/{id}")
	public Map<String, Boolean> deleteWork(@PathVariable(value = "id") Integer workId)
			throws ApiException {
		
		// check valid work_id exists
		validate(workId);

		// delete physics data 
		workRepository.delete(workInfo);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}

	/**
	 * get all data form Database by sorting and Paging.
	 * @param pageIndex page position
	 * @param pageSize data limit per page
	 * @return Page<Work> work information by sorting and Paging.
	 * @throws ApiException exception handle error
	 */
	@GetMapping("fetchlist")
	public Page<Work> getAllWork(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) throws ApiException {
		
		// check that page visibility is always greater than 0
		if (pageIndex > 0) {
			pageIndex--;
		} else {
			throw new ApiException("page not invalid! Please input page greater than 0");
		}
		
		// return data by sorting work_id ASC, and paging by data input
		return workRepository.findAll(PageRequest.of(pageIndex, pageSize, Sort.by(Sort.Direction.ASC, "workId")));
	}

	/**
	 * check exists work_id
	 * @param workId work_id
	 * @throws ApiException exception handle error
	 */
	private void validate(Integer workId) throws ApiException {
		workInfo = workRepository.findById(workId)
				.orElseThrow(() -> new ApiException("Job does not exist, Please try again with another job!"));
	}
}
