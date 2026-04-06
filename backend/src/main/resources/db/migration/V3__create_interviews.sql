CREATE TYPE interview_outcome AS ENUM ('PENDING', 'PASSED', 'FAILED');

CREATE TABLE interviews (
                            id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                            job_id UUID NOT NULL REFERENCES jobs(id) ON DELETE CASCADE,
                            round_number INT NOT NULL DEFAULT 1,
                            interview_type VARCHAR(100),
                            scheduled_at TIMESTAMP,
                            interviewer_name VARCHAR(150),
                            feedback TEXT,
                            outcome interview_outcome DEFAULT 'PENDING',
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);