/*
Guia_0101.
*/
module Guia_0101;
// define data
integer x = 13; // decimal
reg [127:0] b = 0; // binary
// actions
initial
begin : main
$display ( "Guia_0101 - Tests" );
$display ( "x = %d" , x );
$display ( "b = %128b", b );
b = x;
$display ( "b = %128b", b );
end // main
endmodule // Guia_0101