/*
Guia_0102.
*/
module Guia_0102;
// define data
integer x = 0; // decimal
reg [7:0] b = 8'b0101100; // binary
// actions
initial
begin : main
$display ( "Guia_0102 - Tests" );
$display ( "x = %d" , x );
$display ( "b = %8b", b );
x = b;
$display ( "b = %d", x );
end // main
endmodule // Guia_0102