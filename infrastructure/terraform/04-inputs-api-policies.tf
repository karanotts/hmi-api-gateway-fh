
variable "api_policies" {
  default = [
    {
      operationId  = "request-hearing"
      format       = "rawxml-link"
      templateFile = "api-op-request-hearing-policy.xml"
    },
    {
      operationId  = "health-check"
      format       = "rawxml-link"
      templateFile = "api-op-health-check-policy.xml"
    },
    {
      operationId  = "update-hearing"
      format       = "rawxml-link"
      templateFile = "api-op-update-hearing-policy.xml"
    },
    {
      operationId  = "hearings"
      format       = "rawxml-link"
      templateFile = "api-op-retrieve-hearings-policy.xml"
    },
    {
      operationId     = "session"
      format          = "rawxml-link"
      templateFile    = "api-op-retrieve-hearing-sched-policy.xml"
    },
    {
      operationId     = "resource-by-id"
      format          = "rawxml-link"
      templateFile    = "api-op-retrieve-resource-by-id-policy.xml"
    },
    {
      operationId     = "resources"
      format          = "rawxml-link"
      templateFile    = "api-op-retrieve-resources-policy.xml"
    }
  ]
}