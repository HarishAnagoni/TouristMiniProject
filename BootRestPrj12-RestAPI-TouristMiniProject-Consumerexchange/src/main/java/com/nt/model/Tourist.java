package com.nt.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tourist {
	private Integer tid;
	private String tname;
	private String taddrs;
	private Long tmobile;
	private LocalDate tdob;

}
