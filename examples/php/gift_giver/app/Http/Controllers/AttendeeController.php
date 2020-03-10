<?php

namespace App\Http\Controllers;

use App\Models\Attendee;

class AttendeeController extends Controller
{
    public function index() {
        return Attendee::all();
    }
}
