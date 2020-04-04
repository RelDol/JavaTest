package vn.anhnhb.javatestapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import vn.anhnhb.javatestapi.enumtype.StatusJob;

/**
 * Entity Work
 * @author AnhNHB
 * @version 1.0 2020/04/03
 *
 */
@Entity
@Table(name = "work")
public class Work {

	/**
	 * work id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int workId;

	/**
	 * work name
	 */
	@Column(name = "work_name", nullable = false)
	private String workName;

	/**
	 * work start date
	 */
	@JsonFormat(lenient = OptBoolean.FALSE)
	@Column(name = "start_date", nullable = false)
	private Date startDate;

	/**
	 * work end date
	 */
	@JsonFormat(lenient = OptBoolean.FALSE)
	@Column(name = "end_date", nullable = false)
	private Date endDate;

	/**
	 * work status
	 */
	@Enumerated(EnumType.ORDINAL)
	private StatusJob status;

	/**
	 * getter workId
	 * @return workId
	 */
	public int getWorkId() {
		return workId;
	}

	/**
	 * setter workId
	 * @param workId workId
	 */
	public void setWorkId(int workId) {
		this.workId = workId;
	}

	/**
	 * getter workName
	 * @return workName
	 */
	public String getWorkName() {
		return workName;
	}

	/**
	 * setter workName
	 * @param workName workName
	 */
	public void setWorkName(String workName) {
		this.workName = workName;
	}

	/**
	 * getter startDate
	 * @return startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * setter startDate
	 * @param startDate startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * getter endDate
	 * @return endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * setter endDate
	 * @param endDate endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * getter status
	 * @return status
	 */
	public StatusJob getStatus() {
		return status;
	}

	/**
	 * setter status
	 * @param status status
	 */
	public void setStatus(StatusJob status) {
		this.status = status;
	}
}
