﻿using DistComp.Models;

namespace DistComp.DTO.ResponseDTO;

public class MessageResponseDTO
{
    public long Id { get; set; }
    
    public long IssueId { get; set; }
    public Issue Issue { get; set; }
    
    public string Content { get; set; }
}