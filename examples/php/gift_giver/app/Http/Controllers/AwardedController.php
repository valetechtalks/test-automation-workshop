<?php

namespace App\Http\Controllers;

use App\Models\Attendee;

class AwardedController extends Controller
{
    public function index() {
        return Attendee::where('awarded', '=', 1)
                   ->orderBy('name', 'asc')
                   ->get();
    }
}
